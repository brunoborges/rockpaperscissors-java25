# Use Ubuntu as base image for maximum control
FROM ubuntu:22.04

# Avoid prompts from apt
ENV DEBIAN_FRONTEND=noninteractive

# Install base dependencies
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    git \
    unzip \
    ca-certificates \
    sudo \
    bash \
    && rm -rf /var/lib/apt/lists/*

# Create a non-root user
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID

RUN groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

# Install Java 25 (Microsoft distribution)
ENV JAVA_HOME=/opt/java/openjdk
RUN mkdir -p $JAVA_HOME \
    && curl -L "https://aka.ms/download-jdk/microsoft-jdk-25-linux-x64.tar.gz" \
    | tar -xzC $JAVA_HOME --strip-components=1

# Add Java to PATH
ENV PATH="$JAVA_HOME/bin:$PATH"

# Install Maven 4 (latest version available)
ENV MAVEN_HOME=/opt/maven
ENV MAVEN_VERSION=4.0.0-rc-5
RUN mkdir -p $MAVEN_HOME \
    && curl -L "https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/${MAVEN_VERSION}/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    | tar -xzC $MAVEN_HOME --strip-components=1

# Add Maven to PATH
ENV PATH="$MAVEN_HOME/bin:$PATH"

# Set up Maven local repository directory
RUN mkdir -p /home/$USERNAME/.m2 \
    && chown -R $USERNAME:$USERNAME /home/$USERNAME/.m2

# Switch to non-root user
USER $USERNAME

# Set working directory
WORKDIR /workspace

# Verify installations
RUN java --version && mvn --version

# Set default shell
SHELL ["/bin/bash", "-c"]