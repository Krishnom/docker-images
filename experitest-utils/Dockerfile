FROM python:3.9.13


RUN pip install ansible==2.9.27 && \
    pip install pywinrm

RUN apt-get update && \
    apt-get install sshpass



CMD ["ansible", "--version"]