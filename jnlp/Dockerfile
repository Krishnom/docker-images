#Note: If you want to use this image in jenkins, You must keep "command to run" and "arguments" empty in pod template.

FROM jenkins/inbound-agent:jdk11
ARG user=jenkins

USER root
ENV DEBIAN_FRONTEND=noninteractive

#apt-get requires root previledges.
RUN   apt-get update && \
      apt-get install -y curl gcc python3-dev libkrb5-dev && \
      apt-get install -y python3-pip && \
      apt-get install -y sshpass  krb5-user

#Set python3 to default
RUN update-alternatives --install /usr/bin/python python /usr/bin/python3 1


# Install nodejs for seetest-io-accounts-site ci
RUN  curl -fsSL https://deb.nodesource.com/setup_10.x | bash -
RUN  apt-get install -y nodejs npm
RUN  node --version && \
     npm --version


USER ${user}
RUN pip install --upgrade pip && \
    pip install --upgrade virtualenv

#Install Ansible
RUN pip install --user ansible && \
    pip install --user pywinrm && \
    pip install --user pywinrm[kerberos] && \
    pip install awsebcli --upgrade --user && \
    pip install urllib3 --upgrade --user

ENV PATH "$PATH:/home/$user/.local/bin"

ENTRYPOINT ["/usr/local/bin/jenkins-agent"]
#CMD ["bash"]