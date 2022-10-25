FROM ubuntu:latest

RUN apt update

WORKDIR /usr/app/src

COPY L_python.py ./

EXPOSE 443

CMD ["python", "./L_python.py"]
