FROM ubuntu:latest

RUN apt update

WORKDIR /usr/app/src

COPY L_python.py ./

CMD ["python", "./L_python.py"]
