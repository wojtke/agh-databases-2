# Queries - Zad 8

- Zwróć dane wszystkich zamkniętych (open) firm (business). Zapytanie powinno zwracać dane z pól: nazwa, adres, gwiazdki (stars)
    ```
    db.business.find(
        {is_open: 0}, 
        {name: 1, full_address: 1, stars: 1}
    )
    ```
    Result:
    ```
    { 
        "_id" : ObjectId("6264a003e608d43ef4e0203b"), 
        "name" : "Abby Rappoport, LAC, CMQ", 
        "stars" : 5.0
    }
    { 
        "_id" : ObjectId("6264a003e608d43ef4e0203c"), 
        "name" : "Target", 
        "stars" : 3.5
    }
    { 
        "_id" : ObjectId("6264a003e608d43ef4e02045"), 
        "name" : "Tsevi's Pub And Grill", 
        "stars" : 3.0
    }
    ...
    ```

- Ile miejsc ocenianych na 5 gwiazdek (pole stars, kolekcja business) 
    ```
    db.business.find({stars: 5}).count()
    ```
    Result:
    > 16307


- Ile restauracji znajduje się w każdym mieście. (pole categories w dokumencie business musi
zawierać wartość Restaurants).
    ```
    db.business.aggregate([
            { 
                "$match" : { 
                    "categories" : /^.*Restaurants.*$/i
                }
            }, 
            { 
                "$group" : { 
                    "_id" : { 
                        "city" : "$city"
                    }, 
                    "COUNT(*)" : { 
                        "$sum" : 1
                    }
                }
            }, 
            { 
                "$project" : { 
                    "city" : "$_id.city", 
                    "count" : "$COUNT(*)", 
                    "_id" : 0
                }
            }
        ]);
    ```

    Result:
    ```
    { 
        "city" : "Hammonton", 
        "count" : 10.0
    }
    { 
        "city" : "Newfield", 
        "count" : 4.0
    }
    { 
        "city" : "East Alton", 
        "count" : 11.0
    }
    { 
        "city" : "Shamong", 
        "count" : 5.0
    }
    { 
        "city" : "Gulph Mills", 
        "count" : 1.0
    }
    ...
    ```

- Zwróć bez powtórzeń wszystkie nazwy miast w których znajdują się firmy (business)
    ```
    db.business.distinct(city)
    ```

    Result:
    ```
    [
    "AB Edmonton", 
    "AMBLER", 
    "ARDMORE", 
    "AVON", 
    "Abington", 
    "Abington Township", 
    "Affton", 
    "Afton", 
    "Alberta Park Industrial", 
    "Aldan", 
    ...
    ]
    ```


