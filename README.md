## Solution for a Brazilian Challenge called Rinha de Backend - 2024/Q1
A payments API challenge validated by Gatling with concurrent operations and a 500 requests/s peak.
You can find more information about the challenge [here](https://github.com/zanfranceschi/rinha-de-backend-2024-q1).

### Stack
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white)

### How to run
Pre-requisites: 
- Gatling
- Docker
- docker-compose

Clone both repositories using `git clone`:

- Java solution: `https://github.com/jpcairesf/rinha-2024-q1-java`
- Simulation project: `https://github.com/zanfranceschi/rinha-de-backend-2024-q1`

Enter in the simulation project folder `cd rinha-de-backend-2024-q1` and edit the file `executar-teste-local.sh` (.ps1 for power shell) to properly use your Gatling installation directory.

Inside the simulation project folder, run the containers and the Gatling simulation using
`docker-compose -f ./../rinha-2024-q1-java/docker-compose.yml up -d && sh executar-teste-local.sh`

### Constraints
Some constraints were applied to guarantee a fair and more competitive scenario to the challenge.
- 1.5 CPU to distribute between the containers
- 550 MB of memory to distribute between the containers
- Must be able to run in AMD64 architecture

### Results
Test results will be generated in the simulation project `rinha-de-backend-2024-q1/load-test/user-files/results`. Open the index.html file.
