# K8S + Websockets

This POCs is about handling websockets connections using multiple instances of the application.


# Requirements
- Kind
- Podman
- Kubectl


# Installation

## Create cluster
```bash
kind create cluster
```

## Create deployment
I'm deploying an application that use websocket.
Here is the link: https://github.com/codegik/pocs/tree/master/kotlin-jdk21-dontpad

```
NOTE: Please clone this repo to build and deploy the application.
```

### First need to build and save the image
```bash
podman build -t codegik/dontpad .
podman save localhost/codegik/dontpad -o /tmp/dontpad.tar
```

### Load image to kind cluster
```bash
kind load image-archive /tmp/dontpad.tar
```

### Adding pod to k8s cluster
```bash
kubectl apply -f k8s-deploy.yml
```

### Expose port with port-forward
```bash
kubectl port-forward service/dontpad-svc 28015:8080
```

### Capture logs from pods
```bash
kubectl logs dontpad-8484bffc68-snvq6 -f
```

### Accessing the application
You can access dontpad application in http://localhost:28015.

Please open many tabs you can to see multiples connections using websocket.

### Scaling down
Now you can scale down the dontpad application, and will make few clients loose the connection.

```bash
kubectl scale deployment dontpad --replicas=1
```

### Reconnecting
Some client is not able to send or receive messages anymore.
So it's necessary to reload page to reconnect in the server.


## Conclusion
This experiment could help to understand how websockets work in distributed systems.
