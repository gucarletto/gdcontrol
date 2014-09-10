package br.udesc.gdc.dao;

import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author gustavo
 */
public abstract class XMLDAO <T extends Object> extends XMLDAOFactory implements DefaultDAO<T> {
    
    public abstract String getNomeArquivo();
    protected abstract T leituraRegistro(Element element);    
    protected abstract Element criaElement(T t);
    
    protected abstract void alteraRegistro(Document doc, Element e, T t);

    public boolean inserir(T t) {
        boolean inseriu = false;

        File arquivo = new File(getNomeArquivo());
        Document doc = new Document() ;
        XMLOutputter xout = new XMLOutputter();

        SAXBuilder builder = new SAXBuilder();

        try {
            doc = builder.build(arquivo);

            Element elementRaiz = doc.getRootElement();
            boolean existeRegistro = existeRegistro(t);

            if (!existeRegistro) {
                Element element = criaElement(t);

                elementRaiz.addContent(element);
                FileWriter fw = new FileWriter(arquivo);
                xout.output(doc, fw);

                inseriu = true;

            } else {
                JOptionPane.showMessageDialog(null,"Este Registro ja existe");
            }
        } catch (JDOMException | IOException e) {
             e.printStackTrace();
        }
        return inseriu;
    }

    public boolean alterar(T t) {
        boolean achou = false;
        File arquivo = new File(getNomeArquivo());
        SAXBuilder builder = new SAXBuilder(true);
        builder.setFeature("http://apache.org/xml/features/validation/schema", true);

        try {
            Document doc = builder.build(arquivo);
            Element elementRaiz = doc.getRootElement();
            List list = elementRaiz.getChildren();
            int i = 0;
            while ((i < list.size()) && (achou == false)) {

                Element element = (Element) list.get(i);
                T procura = leituraRegistro(element);

                alteraRegistro(doc, element, procura);
                i = i + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return achou;
    }
//
//    @Override
//    public boolean excluir(T procura) {
//        boolean achou = false;
//        File arquivo = new File(getNomeArquivo());
//        SAXBuilder builder = new SAXBuilder(true);
//        builder.setFeature("http://apache.org/xml/features/validation/schema",
//                true);
//        Document doc;
//        FileWriter fw;
//        XMLOutputter xout;
//        try {
//            doc = builder.build(arquivo);
//            Element elementRaiz = doc.getRootElement();
//
//            List listClientes = elementRaiz.getChildren();
//            int i = 0;
//            while ((i < listClientes.size()) && (achou == false)) {
//                Element elementCliente = (Element) listClientes.get(i);
//                Cliente cliente = leituraRegistro(elementCliente);
//
//                if (procura.getCodigo() == cliente.getCodigo()) {
//
//                    elementRaiz.removeContent(elementCliente);
//                    achou = true;
//
//                    xout = new XMLOutputter();
//                    fw = new FileWriter(arquivo);
//                    xout.output(doc, fw);
//
//                }
//                i = i + 1;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        }
//
//        return achou;
//    }
//
    public boolean existeRegistro(T procura) {

        File arquivo = new File(getNomeArquivo());

        SAXBuilder builder = new SAXBuilder(true);
        builder.setFeature("http://apache.org/xml/features/validation/schema",
                true);
        Document doc;
        try {
            doc = builder.build(arquivo);
            Element elementRaiz = doc.getRootElement();

            List ls = elementRaiz.getChildren();

            for (int i = 0; i < ls.size(); i++) {
                //Element el = (Element) list.get(i);
                //Cliente cliente = leituraRegistro(el);
//                if (procura.getCodigo() == cliente.getCodigo()) {
//                    return true;
//                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
//    public String listar() {
//        String saida = "";
//
//        File arquivo = new File(getNomeArquivo());
//        SAXBuilder builder = new SAXBuilder(true);
//        builder.setFeature("http://apache.org/xml/features/validation/schema",
//                true);
//        Document doc;
//
//        try {
//            doc = builder.build(arquivo);
//            Element elementRaiz = (Element) doc.getRootElement();
//            List listClientes = elementRaiz.getChildren();
//            for (int i = 0; i < listClientes.size(); i++) {
//                Element elementCliente = (Element) listClientes.get(i);
//                Cliente cliente = leituraRegistro(elementCliente);
//                saida = saida + cliente.toString() + "\n";
//            }
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return saida;
//    }
//
//    public void alterar(Document doc, Element elementCliente, Cliente novoCliente) {
//
//        Element elementCodigo = elementCliente.getChild("codigo");
//        elementCodigo.setText(novoCliente.getCodigo() + "");
//
//        Element elementNome = elementCliente.getChild("nome");
//        elementNome.setText(novoCliente.getNome());
//
//        Element elementEndereco = elementCliente.getChild("endereco");
//        elementEndereco.setText(novoCliente.getEndereco());
//
//        Element elementSalario = elementCliente.getChild("salario");
//        elementSalario.setText(novoCliente.getSalario() + "");
//
//        Element elementIdade = elementCliente.getChild("idade");
//        elementIdade.setText(novoCliente.getIdade() + "");
//
//        File arquivo = new File(getNomeArquivo());
//        FileWriter fw;
//        XMLOutputter xout;
//        try {
//            xout = new XMLOutputter();
//            fw = new FileWriter(arquivo);
//            xout.output(doc, fw);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public T pesquisar(T procura) {
//        File arquivo = new File(getNomeArquivo());
//
//        SAXBuilder builder = new SAXBuilder(true);
//        builder.setFeature("http://apache.org/xml/features/validation/schema",
//                true);
//        Document doc;
//        try {
//            doc = builder.build(arquivo);
//            Element elementRaiz = doc.getRootElement();
//
//            List listClientes = elementRaiz.getChildren();
//
//            for (int i = 0; i < listClientes.size(); i++) {
//                Element elementCliente = (Element) listClientes.get(i);
//                Cliente cliente = leituraRegistro(elementCliente);
//                if (procura.getCodigo() == cliente.getCodigo()) {
//                    return cliente;
//                }
//            }
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public T pesquisarPorNome(T procura) {
//        File arquivo = new File(getNomeArquivo());
//
//        SAXBuilder builder = new SAXBuilder(true);
//        builder.setFeature("http://apache.org/xml/features/validation/schema",
//                true);
//        Document doc;
//        try {
//            doc = builder.build(arquivo);
//            Element elementRaiz = doc.getRootElement();
//
//            List listClientes = elementRaiz.getChildren();
//
//            for (int i = 0; i < listClientes.size(); i++) {
//                Element elementCliente = (Element) listClientes.get(i);
//                Cliente cliente = leituraRegistro(elementCliente);
//                if (procura.getNome().equalsIgnoreCase(cliente.getNome())) {
//                    return cliente;
//                }
//            }
//        } catch (JDOMException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
    public void zeraArquivo() {
        try {
            File arquivo = new File(getNomeArquivo());

            apagarArquivo(arquivo);
            arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int getQuantidadeRegistro() {
        try {
            File arquivo = new File(getNomeArquivo());

            SAXBuilder builder = new SAXBuilder(true);
            builder.setFeature("http://apache.org/xml/features/validation/schema", true);

            Document doc;

            doc = builder.build(arquivo);
            Element elementRaiz = (Element) doc.getRootElement();
            List reg = elementRaiz.getChildren();
            return reg.size();
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public void apagarArquivo(File arquivo) {
        arquivo = new File(getNomeArquivo());
        // Força a exclusao do arquivo
        if (arquivo.delete() == false) {
            while (arquivo.delete() == false) {
                System.gc();
            }
        }
    }
    
    public long getTamanhoArquivo() {
        File arquivo = new File(getNomeArquivo());
        return arquivo.length();
    }
    
    public int getTamanhoRegistro() {
        // Não tem tamanho fixo
        return (-1);
    }
}