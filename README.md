# Concurrency-Task
* Create two classes: 
* Client - has a list of requests (a class with an int -field) that it sends to the server in asynchronous mode, and receives responses by adding them to another list. 
* Server - receives requests from the client. Processes them (some simple calculation function, for example: resp.value = 100 - req.value).
* The function processing the request has a delay in the form of a random int. Range - up to 2000 ms.
* Test these two classes with multithreading check.
* Test client-server interaction with a separate test (integration).
* In the implementation, use the classes of the java.util.concurrent package (required Lock, Callable, Executor, Future, the rest is optional).
