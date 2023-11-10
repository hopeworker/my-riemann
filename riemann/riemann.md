## What's riemann
Riemann is an event stream processor.

https://riemann.io/concepts.html


## install riemann by docker
https://riemann.io/howto.html#using-docker

```bash
docker run \
  --rm \
  --net host \
  -p 5557:5557 \
  -p 5555:5555 \
  -v /Users/xiongwei/Develop/projects/my-riemann/riemann/riemann.config:/etc/riemann.config \
  riemannio/riemann
```

## how to input events
### install riemann client and tools by docker

see dockerfile ./dockerfile

then build it with docker command and run it:

```bash
## built riemann tools image from dockerfile in current directory
docker build -t my-riemann-tools .

## run in container
docker run -it --rm --net host my-riemann-tools:latest
```

## Writing tests
see ./riemann.my-test.clj

### run tests

```bash
docker run \
  --rm \
  --net host \
  -v /Users/xiongwei/Develop/projects/my-riemann/riemann/riemann.config:/etc/riemann.config \
  -v /Users/xiongwei/Develop/projects/my-riemann/riemann/riemann.my-test.clj:/etc/riemann.my-test.clj \
  riemannio/riemann \
  riemann test /etc/riemann.my-test.clj
```


## Others

### run riemann manually in docker
docker run -it --rm --net host --name riemann-command riemannio/riemann:latest /bin/bash
root@docker-desktop:# /bin/riemann etc/riemann.config

##### reference
https://hub.docker.com/layers/riemannio/riemann/latest/images/sha256-a5bf24e8c4690c1a8925616954778e5908ccfed95e241a334a125b0fd9d37031?context=explore
CMD ["/bin/riemann" "/etc/riemann.config"]

https://hub.docker.com/r/stealthly/docker-riemann/dockerfile