package com.gabriel.smarorder.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.smarorder.domain.models.Comanda;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public class ComandaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private byte[] imagem;
    private Integer produtoId; // Adiciona o ID do produto

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;

    @NotNull(message = "O campo PRIORIDADE é requerido")
    private Integer prioridade;

    @NotNull(message = "O campo STATUS é requerido")
    private Integer status;

    @NotNull(message = "O campo TITULO é requerido")
    private String titulo;

    @NotNull(message = "O campo OBSERVAÇÕES é requerido")
    private String observacoes;

    @NotNull(message = "O campo MESA é requerido")
    private String mesa;

    @NotNull(message = "O campo CLIENTE é requerido")
    private Integer cliente;

    @NotNull(message = "O campo FUNCIONÁRIO é requerido")
    private Integer funcionario;

    private String nomeFuncionario;
    private String nomeCliente;

    public ComandaDTO() {
        super();
    }

    public ComandaDTO(Comanda obj) {
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade().getCodigo();
        this.status = obj.getStatus().getCodigo();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();
        this.mesa = obj.getMesa();
        this.cliente = obj.getCliente().getId();
        this.funcionario = obj.getFuncionario().getId();
        this.nomeFuncionario = obj.getFuncionario().getNome();
        this.nomeCliente = obj.getCliente().getNome();

        if (obj.getItens() != null && !obj.getItens().isEmpty()) {
            this.produtoId = obj.getItens().get(0).getProduto().getId();
        } else {
            this.produtoId = null;
        }
    }


    // Getters e Setters

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
}
