# Modeling - Zad 9 

### Zaproponuj strukturę bazy danych dla wybranego/przykładowego zagadnienia/problemu

Wykładowcy, przedmioty, studenci, oceny
- Wykładowcy prowadzą zajęcia z poszczególnych przedmiotów
- Studenci uczęszczają na zajęcia
- Wykładowcy wystawiają oceny studentom
- Studenci oceniają zajęcia

### Moja propozycja - podzielić na kolekcje:
- #### teachers
    Prowadzący <br>
    example:
    ```
    {
        "teacher_id": "t2",
        "firstname": "John",
        "lastname": "Doe",
        "mail": "JohnDoe@teacher.edu",
        "gender": "m",
        "active": true,
        "courses_taught": ["c1", "c2", "c4"]
    },
    ```

- #### students
    Student <br>
    example:
    ```
    {
        "student_id": "s3",
        "firstname": "Miranda",
        "lastname": "Linkage",
        "mail": "MirandaLinkage@student.edu",
        "gender": "f",
        "active": true,
        
        "courses": [
            {
                "course_id" : "c4",
                "semester": "spring",
                "year": 2020,
                "course_name" : "Statistics",
                
                "status" : "passed",
                "grades" : {
                    "partial" : [4,4,4,4,5],
                    "average" : 4.2,
                    "final" : 4
                }
            }
                
        ],
        
        "total_ects" : 2
    }
    ```
    Pole "total_ects" - computed field sumujący wszystkie uzyskane ects, podobnie funkcjonuje "average" w grades.

- #### courses
    Przedmiot <br>
    example:
    ```
    {
        "course_id": "c1",
        "name" : "Linear algebra",
        "ects" : 12,
        "course_instances" : [
            {
                "semester": "winter",
                "year": 2021,
                "teacher": "t2"
            },
            {
                "semester": "winter",
                "year": 2020,
                "teacher": "t1"
            },
            
        ]
    },
    ```
    Course instance - dany kurs może odbywać się wielokrotnie (np. co roku) z innym prowadzącym innymi studentami.
- #### classes
    Pojedyńcze zajęcia <br>
    example:
    ```
     {
        "course_id": "c2",
        "date": "2022-12-12",
        "subject": "Keepin it cool",
        "teacher_id": "t2",
        
        "attendance": ["s1", "s2"],
        
        "reviews": [
            {
                "student_id": "s1",
                "rating": 4,
                "comment":"Damn good!"
            },
            {
                "student_id": "s2",
                "rating": 2,
                "comment":"Wacky, no bread..."
            }
        ]
    }
    ```
    Attendance to lista obecności, reviews to oceny studentów (student może ocenić każde zajęcia na których był)

### Potencjalne problemy 
- Przez rozmieszczenie (często zdublowanie) danych w różnych miejscach mamy wygodę przeszukiwania, ale może to doprowadzić do niespójności.

- Nie byłem pewny gdzie powinna znajdować się sekcja z ocenami. Umieściłem ją w dokumencie studenta, natomiast równie sensownie możnaby dodać poddokument z ocenami w dokumencie kursu (lub raczej jego instancji).

- Kursy i instancje kursów mogą mylić się ze sobą. Student uczęszcza na zajęcia z "Algebry", po czym zdaje przedmiot "Algebra" - niby to samo, ale jest lekka różnica. Niejasne dla mnie jak to modelować