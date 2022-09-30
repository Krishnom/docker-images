FROM ghcr.io/runatlantis/atlantis:v0.19.7

ARG GLIBC_VERSION=2.34-r0
ARG AWSCLI_VERSION=2.6.1

# gcompat (required and installed by atlantis) triggers a conflict when
# installing the glibc shim.
RUN apk --no-cache add \
		binutils \
	&& curl -sL https://alpine-pkgs.sgerrand.com/sgerrand.rsa.pub -o /etc/apk/keys/sgerrand.rsa.pub \
	&& curl -sLO https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GLIBC_VERSION}/glibc-${GLIBC_VERSION}.apk \
	&& curl -sLO https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GLIBC_VERSION}/glibc-bin-${GLIBC_VERSION}.apk \
	&& curl -sLO https://github.com/sgerrand/alpine-pkg-glibc/releases/download/${GLIBC_VERSION}/glibc-i18n-${GLIBC_VERSION}.apk \
	&& apk del gcompat \
	&& apk add --no-cache \
			glibc-${GLIBC_VERSION}.apk \
			glibc-bin-${GLIBC_VERSION}.apk \
			glibc-i18n-${GLIBC_VERSION}.apk \
	&& /usr/glibc-compat/bin/localedef -i en_US -f UTF-8 en_US.UTF-8 \
	&& curl -sL https://awscli.amazonaws.com/awscli-exe-linux-x86_64-${AWSCLI_VERSION}.zip -o awscliv2.zip \
	&& unzip awscliv2.zip \
	&& aws/install \
	&& rm -rf \
			awscliv2.zip \
			aws \
			/usr/local/aws-cli/v2/current/dist/aws_completer \
			/usr/local/aws-cli/v2/current/dist/awscli/data/ac.index \
			/usr/local/aws-cli/v2/current/dist/awscli/examples \
			glibc-*.apk \
	&& find /usr/local/aws-cli/v2/current/dist/awscli/botocore/data -name examples-1.json -delete \
	&& apk --no-cache del \
			binutils \
	&& rm -rf /var/cache/apk/*