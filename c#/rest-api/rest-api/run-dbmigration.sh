#!/bin/bash

dotnet ef migrations add initial
dotnet ef database update

