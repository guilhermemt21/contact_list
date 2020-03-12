FROM mysql:5.7
# Add a database
ENV MYSQL_DATABASE contact_list
ENV MYSQL_ALLOW_EMPTY_PASSWORD true