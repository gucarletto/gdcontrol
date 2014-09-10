package com.gdcontrol.dao.xml;

import com.gdcontrol.dao.XMLDAO;
import com.gdcontrol.dao.core.GrupoAlimentoDAO;
import com.gdcontrol.modelo.GrupoAlimento;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author gustavo
 */
public class XMLGrupoAlimentoDAO extends XMLDAO<GrupoAlimento> implements GrupoAlimentoDAO{

    @Override
    public String getNomeArquivo() {
        return "grupoalimento.xml";
    }

    @Override
    protected GrupoAlimento leituraRegistro(Element element) {
        GrupoAlimento grp = new GrupoAlimento();
        grp.setId(Integer.parseInt(element.getChildText("id")));
        grp.setDescricao(element.getChildText("descricao"));
        return grp;
    }
    
    @Override
    protected Element criaElement(GrupoAlimento t) {
        Element elementGrp = new Element("grupo_alimento");
        Element elementId = new Element("id");
        elementId.setText(t.getId() + "");
        elementGrp.addContent(elementId);

        Element elementNome = new Element("descricao");
        elementNome.setText(t.getDescricao());
        elementGrp.addContent(elementNome);
        
        return elementGrp;
    }

    protected void alteraRegistro(Document doc, Element el, GrupoAlimento t) {
        Element elementId = el.getChild("id");
        elementId.setText(t.getId()+ "");

        Element elementDescricao = el.getChild("descricao");
        elementDescricao.setText(t.getDescricao());

        File arquivo = new File(getNomeArquivo());
        FileWriter fw;
        XMLOutputter xout;
        try {
            xout = new XMLOutputter();
            fw = new FileWriter(arquivo);
            xout.output(doc, fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean excluir(GrupoAlimento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoAlimento persistir(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GrupoAlimento> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}