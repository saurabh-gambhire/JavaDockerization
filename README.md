# JavaDockerization

- Ask permission before clone.

  Steps :
  1. clone the Repository
  2. see is there any docker images or containers running locally.
       docker ps
       docker ps -a
       docker images
  3. go to project directory
  4. try to run poject locally.
  5. once the project run successfully. build it locally.
      Use - mvn clean package -Dskiptest
          - docker compose build
  7. up the docker compose file.
      Use -   sudo docker compose -f docker-compose.yml up -d
