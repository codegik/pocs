FROM jenkins/jenkins:lts

USER root

RUN wget https://releases.hashicorp.com/terraform/0.12.7/terraform_0.12.7_linux_amd64.zip
RUN unzip terraform_0.12.7_linux_amd64.zip
RUN mv terraform /usr/local/bin/
RUN chmod +x /usr/local/bin/terraform

