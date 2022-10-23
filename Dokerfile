FROM ubuntu:latest

RUN apt update
RUN apt python3 -y

WORKDIR /usr/app/src

COPY L_python.py ./

CMD ["python3", "L_python.py"]
