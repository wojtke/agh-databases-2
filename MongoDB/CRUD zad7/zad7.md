# Basic CRUD - Zad7

- Create database and collection
    ```
    use WJ;
    db.createCollection("students");
    ```

- Insert student
    ```
    student = {
        "firstname": "Mike",
        "lastname": "Bike",
        "student_id": "420",
        "email": "MikeBike@email.com",
        "gender" : "m",
        "student_status_active" : true,
        "address": {
            "street" : "Long st.",
            "city" : "Cracow",
            "zip_code" : "13-123",
        },
        "courses" : [
            {
                "course_id" : 111,
                "grade" : 5.0
            },
            {
                "course_id" : 222,
                "grade" : 5.0
            },
            {
                "course_id" : 333,
                "grade" : 4.0
            }
        ]
    }

    db.students.insert(student)
    ```

- Or insert many at once
    ```
    students = [...]
    db.students.insertMany(students)
    ```

- Read 
    ```
    db.students.find()
    db.students.find({ "gender" : "m", })
    ```

- Update sth
    ```
    db.students.updateMany(
        { "gender" : "m"}, 
        { $set : {"student_status_active" : false}} 
    )
    ```

- Delete sth
    ```
    db.students.deleteOne(
        { "firstname" : "Mike"}
    )
    ```
