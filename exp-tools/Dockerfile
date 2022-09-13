#Note: If you want to use this image in jenkins, You must keep "command to run" and "arguments" empty in pod template.

FROM jenkins/inbound-agent:jdk11
ARG user=jenkins

USER root
ENV DEBIAN_FRONTEND=noninteractive

#apt-get requires root previledges.
RUN         apt-get update
RUN         apt-get install -y curl gcc python3-dev libkrb5-dev
RUN         apt-get install -y python3-pip python3-venv
RUN         apt-get install -y sshpass  krb5-user
RUN         apt-get install -y postgresql-client
RUN         apt-get install unzip wget -y
RUN         apt-get install jq -y
RUN         apt-get install poppler-utils -y  #pdfinfo binary for barclays reporting jobs
RUN         apt-get install vim -y
#Set python3 to default
RUN update-alternatives --install /usr/bin/python python /usr/bin/python3 1


# Install nodejs for seetest-io-accounts-site ci
RUN  curl -fsSL https://deb.nodesource.com/setup_10.x | bash -
RUN  apt-get install -y nodejs npm
RUN  node --version && \
     npm --version
RUN wget https://releases.hashicorp.com/terraform/1.2.8/terraform_1.2.8_linux_arm64.zip && \
    unzip terraform_1.2.8_linux_arm64.zip

# Move to local bin
RUN mv terraform /usr/local/bin/
## Check that it's installed
#RUN terraform --version

USER ${user}
RUN pip install --upgrade pip && \
    pip install --upgrade virtualenv

#Install Ansible
RUN pip install --user ansible && \
    pip install --user pywinrm && \
    pip install --user pywinrm[kerberos] && \
    pip install awsebcli --upgrade --user && \
    pip install urllib3 --upgrade --user && \
    pip install fortiosapi --upgrade --user && \
    pip install hvac --upgrade --user && \
    pip install ncclient --upgrade --user && \
    pip install awscli --upgrade --user && \
    pip install zabbix-api --upgrade --user && \
    pip install pyvmomi

ENV PATH "$PATH:/home/$user/.local/bin"

RUN ansible-galaxy collection install community.general && \
    ansible-galaxy collection install junipernetworks.junos

ENTRYPOINT ["/usr/local/bin/jenkins-agent"]
#CMD ["bash"]