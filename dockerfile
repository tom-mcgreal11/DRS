FROM alpine:3.14

RUN apk update && apk add bash

ADD hello /

RUN chmod +x /hello
CMD /hello
