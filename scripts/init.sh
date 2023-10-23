cd ../services/product/
docker build -t product:latest --no-cache -f dockerfile .
cd ../../services/orders/
docker build -t orders:latest --no-cache -f dockerfile .
cd ../../scripts/
docker compose up