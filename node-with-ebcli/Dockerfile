#FROM node:14.18.2
#RUN python --version
#RUN apt-get update && \
#    apt-get install -y software-properties-common && \
#    rm -rf /var/lib/apt/lists/*
#
#RUN add-apt-repository ppa:deadsnakes/ppa && \
#    apt-get update && \
#    apt-get install curl python3.7 && \
#    curl -O https://bootstrap.pypa.io/get-pip.py && \
#    python3 get-pip.py --user && pip --version
#
#RUN pip install awsebcli --upgrade --user && \
#    eb --version
#ENV PATH "$PATH:/root/.local/bin"
FROM nikolaik/python-nodejs:python3.10-nodejs14
RUN  pip install awsebcli --upgrade --user
ENV PATH "$PATH:/root/.local/bin"
RUN eb --version