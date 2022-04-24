# MongoDB

### Setup
- Run in this directory:
    ```
    docker compose up -d
    ```

- Check the container_ID for "mongodb"
    ```
    docker ps
    ```

- Download yelp dataset: https://www.yelp.com/dataset
- Copy the yelp dataset onto the container
    ```
    docker cp yelp_academic_dataset_business.json <container_ID>:/business.json
    ```

- Run the thing
    ```
    docker exec -it <container_ID> bash
    ```

- Add the dataset as as collection
    ```
    mongoimport --uri=mongodb://root:toor@localhost:27017/WJ?authSource=admin --collection=business --file=/business.json
    ```

- Connect to the mongo shell
    ```
    mongo mongodb://localhost:27017 -u root -p toor
    ```

- Or use mongo-express: http://localhost:8081/