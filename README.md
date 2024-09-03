# API Documentation - SmartOrder

Este documento fornece uma visão geral das rotas disponíveis na API SmartOrder. A API é construída usando Spring Boot e segue as práticas RESTful.

## Índice

- [Analytics](#analytics)
- [Clientes](#clientes)
- [Comandas](#comandas)
- [Funcionários](#funcionários)
- [Produtos](#produtos)

---

## Analytics

### `GET /api/analytics`
Retorna dados de análise das comandas.

**Response:**
- `200 OK`: Retorna um mapa contendo os dados de análise com chaves como `totalComandas`, `comandasEncerradas`, etc.

### `GET /api/analytics/monthly-data`
Retorna dados analíticos mensais.

**Response:**
- `200 OK`: Retorna um mapa contendo dados agrupados por mês.

### `GET /api/analytics/priority-data`
Retorna dados de prioridade das comandas.

**Response:**
- `200 OK`: Retorna uma lista contendo a contagem de comandas por prioridade.

---

## Clientes

### `GET /clientes/{id}`
Retorna os detalhes de um cliente específico.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Response:**
- `200 OK`: Retorna o `ClienteDTO` com os dados do cliente.
- `404 Not Found`: Cliente não encontrado.

### `GET /clientes`
Retorna uma lista de todos os clientes.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Response:**
- `200 OK`: Retorna uma lista de `ClienteDTO`.

### `POST /clientes`
Cria um novo cliente.

**Request Body:**
- `ClienteDTO`: Contém os dados necessários para criar um cliente.

**Response:**
- `201 Created`: Cliente criado com sucesso.
- `400 Bad Request`: Erro na validação dos dados fornecidos.

### `PUT /clientes/{id}`
Atualiza os dados de um cliente existente.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Request Body:**
- `ClienteDTO`: Contém os dados atualizados do cliente.

**Response:**
- `200 OK`: Cliente atualizado com sucesso.
- `404 Not Found`: Cliente não encontrado.

### `DELETE /clientes/{id}`
Exclui um cliente.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Response:**
- `204 No Content`: Cliente excluído com sucesso.
- `404 Not Found`: Cliente não encontrado.

---

## Comandas

### `GET /comandas/{id}`
Retorna os detalhes de uma comanda específica.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Response:**
- `200 OK`: Retorna o `ComandaDTO` com os dados da comanda.
- `404 Not Found`: Comanda não encontrada.

### `GET /comandas`
Retorna uma lista de todas as comandas.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Response:**
- `200 OK`: Retorna uma lista de `ComandaDTO`.

### `POST /comandas`
Cria uma nova comanda.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Request Body:**
- `ComandaDTO`: Contém os dados necessários para criar uma comanda.

**Response:**
- `201 Created`: Comanda criada com sucesso.
- `400 Bad Request`: Erro na validação dos dados fornecidos.

### `PUT /comandas/{id}`
Atualiza os dados de uma comanda existente.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Request Body:**
- `ComandaDTO`: Contém os dados atualizados da comanda.

**Response:**
- `200 OK`: Comanda atualizada com sucesso.
- `404 Not Found`: Comanda não encontrada.

### `GET /comandas/poll`
Retorna as comandas atualizadas desde um determinado horário.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Query Param:**
- `lastUpdateTime` (opcional): Hora da última atualização (formato ISO 8601).

**Response:**
- `200 OK`: Retorna uma lista de `ComandaDTO`.

### `PATCH /comandas/{id}/status`
Atualiza o status de uma comanda.

**Pre-Authorization:** `ADMIN`, `FUNCIONARIO`

**Request Body:**
- `novoStatus`: Novo status da comanda.

**Response:**
- `200 OK`: Comanda atualizada com sucesso.
- `404 Not Found`: Comanda não encontrada.

---

## Funcionários

### `GET /funcionarios/{id}`
Retorna os detalhes de um funcionário específico.

**Pre-Authorization:** `ADMIN`

**Response:**
- `200 OK`: Retorna o `FuncionarioDTO` com os dados do funcionário.
- `404 Not Found`: Funcionário não encontrado.

### `GET /funcionarios`
Retorna uma lista de todos os funcionários.

**Pre-Authorization:** `ADMIN`

**Response:**
- `200 OK`: Retorna uma lista de `FuncionarioDTO`.

### `POST /funcionarios`
Cria um novo funcionário.

**Pre-Authorization:** `ADMIN`

**Request Body:**
- `FuncionarioDTO`: Contém os dados necessários para criar um funcionário.

**Response:**
- `201 Created`: Funcionário criado com sucesso.
- `400 Bad Request`: Erro na validação dos dados fornecidos.

### `PUT /funcionarios/{id}`
Atualiza os dados de um funcionário existente.

**Pre-Authorization:** `ADMIN`

**Request Body:**
- `FuncionarioDTO`: Contém os dados atualizados do funcionário.

**Response:**
- `200 OK`: Funcionário atualizado com sucesso.
- `404 Not Found`: Funcionário não encontrado.

### `DELETE /funcionarios/{id}`
Exclui um funcionário.

**Pre-Authorization:** `ADMIN`

**Response:**
- `204 No Content`: Funcionário excluído com sucesso.
- `404 Not Found`: Funcionário não encontrado.

---

## Produtos

### `GET /api/produtos/{id}`
Retorna os detalhes de um produto específico.

**Response:**
- `200 OK`: Retorna o produto.
- `404 Not Found`: Produto não encontrado.

### `GET /api/produtos`
Retorna uma lista de todos os produtos.

**Response:**
- `200 OK`: Retorna uma lista de produtos.

### `POST /api/produtos`
Cria um novo produto.

**Request Body:**
- Dados do produto.

**Response:**
- `201 Created`: Produto criado com sucesso.
- `400 Bad Request`: Erro na validação dos dados fornecidos.

### `PUT /api/produtos/{id}`
Atualiza os dados de um produto existente.

**Request Body:**
- Dados do produto.

**Response:**
- `200 OK`: Produto atualizado com sucesso.
- `404 Not Found`: Produto não encontrado.

### `DELETE /api/produtos/{id}`
Exclui um produto.

**Response:**
- `204 No Content`: Produto excluído com sucesso.
- `404 Not Found`: Produto não encontrado.

### `GET /api/produtos/{id}/imagem`
Retorna a imagem de um produto específico.

**Response:**
- `200 OK`: Retorna a imagem do produto.
- `404 Not Found`: Produto ou imagem não encontrada.

---

## Autenticação e Autorização

Algumas rotas exigem autenticação e autorização baseadas em roles (`ADMIN`, `FUNCIONARIO`). Isso é gerenciado usando anotações do Spring Security, como `@PreAuthorize`.

---
## Responsável pelo Projeto

<table>
  <tr>
    <td align="center">
      <a href="#" title="contribuidor">
        <img src="https://avatars.githubusercontent.com/u/60861872?s=400&u=49b2e6b1034e45f02529c6e165c41de8300ed350&v=4" width="100px;" alt="Foto do Gabriel"/><br>
        <sub>
          <b>Gabriel André</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## Contribuição

Para mais informações, entre em contato com: gabriel.alsilva@ufn.edu.br


Este README oferece uma visão geral das principais rotas da API. Para mais detalhes, como exemplos de payloads ou respostas, consulte a documentação específica ou o código-fonte.
