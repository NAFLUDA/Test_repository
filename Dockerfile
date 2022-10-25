FROM python:latest

RUN apt update

WORKDIR /usr/app/src

COPY L_python.py ./

EXPOSE 5000

CMD ["python", "./L_python.py"]
