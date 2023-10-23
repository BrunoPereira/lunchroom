# lunchroom

First try using Spring Framework

## How to build

```bash
cd scripts
```

If the images for the product and the order haven't been build yet

```bash
./init.sh
```

After the init.sh run 1 time and the images already exist 

```bash
docker compose up
```

## Accessing the services (the docker compose must be up)

### Product endpoint
http://localhost:8081/swagger-ui/index.html

### Orders endpoint (OAuth2 login)
http://localhost:8082/swagger-ui/index.html
