package java.br.udesc.gdc.dao.xml;

import java.br.udesc.gdc.dao.XMLDAO;
import java.br.udesc.gdc.dao.core.GrupoAlimentoDAO;
import java.br.udesc.gdc.model.GrupoAlimento;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;


/**
 *
 * @author gustavo
 */
public class XMLGrupoAlimentoDAO extends XMLDAO<Object> implements GrupoAlimentoDAO{

    @Override
    public String getNomeArquivo() {
        return "grupoalimento.xml";
    }

    @Override
    protected GrupoAlimento leituraRegistro(Element element) {
        GrupoAlimento grp = new GrupoAlimento();
        grp.setId(Integer.parseInt(element.getChildText("codigo")));
        grp.setDescricao(element.getChildText("descricao"));
        return grp;
    }
    
    protected Element criaElement(GrupoAlimento grp) {
        Element elementGrp = new Element("grupo_alimento");
        Element elementId = new Element("id");
        elementId.setText(grp.getId() + "");
        elementGrp.addContent(elementId);

        Element elementDescricao = new Element("descricao");
        elementDescricao.setText(grp.getDescricao());
        elementGrp.addContent(elementDescricao);
        
        return elementGrp;
    }

    protected void alteraRegistro(Document doc, Element el, GrupoAlimento grp) {
//        Element elementId = el.getChild("id");
//        elementId.setText(grp.getId()+ "");
//
//        Element elementNome = el.getChild("descricao");
//        elementNome.setText(grp.getDescricao());
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
    }
}