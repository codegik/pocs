# Recommendation System

This is a POC using LLM to recommend movies based on a dataset.

## Requirements
- Python 3.11

## Installation
```bash
pip install pandas sentence_transformers chromadb
```

## Running
```bash
python main.py
```
Its going to import the dataset and intpu
## Zscaler Troubleshooting

If you are behind a Zscaler proxy, you may need to set the following environment variables:
```bash
pip install certifi | pip install --upgrade certifi
cat ZscalerRootCA.pem >> $(python -m certifi)
pip config set global.cert $(python -m certifi)

export CERT_PATH=$(python -m certifi) 
export SSL_CERT_FILE=${CERT_PATH} 
export REQUESTS_CA_BUNDLE=${CERT_PATH} 
```
