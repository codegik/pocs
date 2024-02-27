# K8S + Websockets

This POCs is about handling websockets connections using multiple instances of the application.


# Requirements
- Kind
- Podman
- Kubectl


# Installation

## Create cluster
```bash
$ kind create cluster
```

## Create deployment
I'm deploying an application that use websocket.
Here is the link: https://github.com/codegik/pocs/tree/master/kotlin-jdk21-dontpad

### First need to build the image
```bash
podman build -t codegik/dontpad .
```

### Create deployment
```bash
$ kubectl apply -f - <<EOF
apiVersion: v1
kind: Pod
metadata:
  name: dontpad
spec:
  containers:
  - name: dontpad
    image: codegik/dontpad:latest
EOF
```
