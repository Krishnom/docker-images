FROM jenkins/agent:latest-alpine-jdk11

USER root
ADD experitest-godady.cer .
RUN keytool -importcert -noprompt  -trustcacerts -alias experitest-CA \
  -keystore /opt/java/openjdk/lib/security/cacerts \
  -file experitest-godady.cer \
  -storepass changeit
USER jenkins

ENTRYPOINT ["/usr/local/bin/jenkins-agent"]