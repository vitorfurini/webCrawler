axreng-test


Desafio técnico realizado para processo seletivo

Para buildar o projeto você precisa ir até a raiz do projeto e abrir o git bash ou cmd e soltar este comando: docker build . -t axreng-test


Para executar o projeto você precisa executar este comando: docker run -e BASE_URL=http://hiring.axreng.com/ -e KEYWORD=manual -e MAX_RESULTS=10 --rm axreng-test


As variáveis BASE_URL, KEYWORD e MAX_RESULTS vão de acordo com a sua necessidade, sendo que:

A variável BASE_URL é obrigatória e deve ser de algum site que utilize os protocolos HTTP ou HTTPS.

A variável KEYWORD também é obrigatória e deve ser uma palavra válida, utilizando apenas caracteres alfanuméricos, acima de 4 e ter 20 caracteres.

A variável MAX_RESULTS não és obrigatória, és o valor que o usuário determina para que a aplicação encontre o valor especificado.
