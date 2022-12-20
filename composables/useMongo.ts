import { MongoClient, MongoClientOptions } from "mongodb";


export const useMongo = () => {
    const connectionString: string = process.env.DB_CONN_STRING as string;
    const dbName: string = process.env.DB_NAME as string
    const collectionName: string = process.env.COLLECTION_NAME as string

    return useState('mongo', async () => {
        let client = new MongoClient(
            connectionString || "mongodb://localhost:27017/",
            { useUnifiedTopology: true } as MongoClientOptions
        );

        const collection = client
            .db(dbName)
            .collection(collectionName);

        return collection;
    })
}