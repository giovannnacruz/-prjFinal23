function cadastrarJogo() {
    const nomejogo = document.getElementById('nomejogo').value;
    const generojogo = document.getElementById('generojogo').value;
    const squad = document.getElementById('squad').value;
    const integrantes = document.getElementById('integrantes').value;
    let url = document.getElementById('url').value;
    let thumbnail = document.getElementById('thumbnail').value;
    
    // Remover o prefixo "http://"
    url = url.replace(/^https?:\/\//, '');
    thumbnail = thumbnail.replace(/^https?:\/\//, '');
   
    const requestBody = {
    nomejogo,
    generojogo,
    squad,
    integrantes,
    url,
    thumbnail
    };

    fetch('http://localhost:8080/jogos/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestBody),
    })
        .then(response => response.json())
        .then(data => {
            alert('Jogo cadastrado com sucesso!');
            document.getElementById('cadastroForm').reset();
             location.reload();
        })
        .catch(error => {
            console.error('Erro ao cadastrar jogo:', error);
        });
}

function ListarJogos() {
    fetch(`http://localhost:8080/jogos`)
        .then(response => {
            if (response.status === 404) {
                return Promise.reject('Lista de Jogos não encontrada');
            }
            return response.json();
        })
        .then(data => {
            const tbodyElement = document.getElementById('jogos-tabela').querySelector('tbody');
            tbodyElement.innerHTML = '';
            // Preenche a tabela com os resultados da pesquisa
            data.forEach(jogo => {
                const linhaJogo = document.createElement('tr');
                linhaJogo.innerHTML = `
                    <td>${jogo.idjogo}</td>
                    <td>${jogo.nomejogo}</td>
                    <td>${jogo.generojogo}</td>
                    <td>${jogo.squad}</td>
                    <td>${jogo.integrantes}</td>
                    <td>${jogo.url}</td>
                    <td><a href="https://${jogo.thumbnail}">Acesse a imagem</a></td>
                `;
                tbodyElement.appendChild(linhaJogo);
            });  
        })
        // Trata os Erros
        .catch(error => {
            console.error('Erro ao pesquisar funcionário:', error);
            const resultadoPesquisa = document.getElementById('resultadoPesquisa');
            resultadoPesquisa.innerHTML = 'Jopo não encontrado.';
        });
}