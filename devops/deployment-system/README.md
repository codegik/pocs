
## Requirements
- OpenTofu
- Colima
- Kind

## Startup the cluster
```bash
export KIND_EXPERIMENTAL_PROVIDER=colima
kind create cluster
```

## Build the Infra
```bash
export OPENTOFU_ENFORCE_GPG_VALIDATION=false
cd iac/src
tofu init
```

