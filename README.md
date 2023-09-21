# springboot_elasticSearch
An example of elastic search used in Spring data: to explore the basics of 
Spring Data Elasticsearch in a code-focused and practical manner.

# Purpose
Learn how to index, search, and query Elasticsearch in a Spring application using Spring DAta Elasticsearch.

# Spring Data Elasticsearch
It is a Spring module that implements Spring Data, thus offering a way to interact with the popular open-source, Lucene-based
search engine.  While Elasticsearch can work without a hardly defined schema, it’s still a common practice to design one 
and create mappings specifying the type of data we expect in certain fields. When a document is indexed, 
its fields are processed according to their types. For example, a text field will be tokenized and filtered according 
to mapping rules. We can also create filters and tokenizers of our own.

For the sake of simplicity, we’ll use a docker image for our Elasticsearch instance, 
though any Elasticsearch instance listening on port 9200 will do. e.g.4:
docker run -d --name es762 -p 9200:9200 -e "discovery.type=single-node" elasticsearch:7.6.2

# Spring Data
Spring Data helps avoid boilerplate code.  For example, if we define a repository interface that extends 
the ElasticsearchRepository interface that Spring Data Elasticsearch provides, CRUD operations for the corresponding document class will become available by default.

