# Installing Xubuntu in MacOS M1 with QEMU

This is a complete installation of Xubuntu including GUI and network.

## Installing QEMU

```
brew install qemu
```

## Create linux image (empty)

```
qemu-img create -f qcow2 xubuntu.qcow2 60G
```

## Download Xubuntu image

```
curl -L -o xubuntu-23.10-minimal-amd64.iso http://mirror.us.leaseweb.net/ubuntu-cdimage/xubuntu/releases/23.10/release/xubuntu-23.10-minimal-amd64.iso
```

## Installing Xubuntu in local image

```
qemu-system-x86_64 -smp 8 -m 4G -cdrom xubuntu-23.10-minimal-amd64.iso -drive file=xubuntu.qcow2,if=virtio

```

## Starting Xubuntu after installation

```
qemu-system-x86_64 -smp 8 -m 4G -drive file=xubuntu.qcow2,if=virtio
```
