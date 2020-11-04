hey -z 30s -c 25 http://localhost:8081/ping && \
    hey -z 30s -c 50 http://localhost:8081/ping && \
    hey -z 30s -c 75 http://localhost:8081/ping && \
    hey -z 30s -c 100 http://localhost:8081/ping && \
    hey -z 30s -c 125 http://localhost:8081/ping && \
    hey -z 30s -c 150 http://localhost:8081/ping &

hey -z 30s -c 25 http://localhost:8082/ping && \
    hey -z 30s -c 50 http://localhost:8082/ping && \
    hey -z 30s -c 75 http://localhost:8082/ping && \
    hey -z 30s -c 100 http://localhost:8082/ping && \
    hey -z 30s -c 125 http://localhost:8082/ping && \
    hey -z 30s -c 150 http://localhost:8082/ping &