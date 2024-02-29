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
kubectl port-forward deployment/dontpad 28015:8080
or
kubectl port-forward service/dontpad-svc 28015:8080
```

### Capture logs from pods
```bash
kubectl logs dontpad-8484bffc68-snvq6 -f
```
