package org.sc.views;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	 
    /*
     * Podiamos usar qualquer uma das classes abaixo mas para simplificar
     * vamos usar um objecto do tipo Image que obtemos atrav�s de um ImageIcon
     * que tem m�todos mais simples para carregar imagens, embora n�o permite a
     * mesma optimiza��o que, por exemplo, um BufferedImage.
     *
     * Image � uma classe abstracta.
     *
     * Image, ImageBuffered, ImageIcon
     */
    private Image image;
 
    /**
     * Construtor que ir� receber a imagem e defini-la como existindo no fundo
     * do painel.
     * 
     * @param url URL com a imagem a colocar no fundo.
     */
    public ImagePanel(String url) {
 
        /*
         * Para evitar repetir c�digo vamos j� usar o m�todo seImage. Usar os sets/gets
         * no construtor pode ajudar a manter a validade dos dados se, principalmente,
         * os sets fizerem alguma valida��o. Neste caso � simplesmente para n�o
         * repetir o mesmo c�digo
         */
        setImage(url);
 
        //Fundamental que a propriedade seja coloca a false ou a imagem n�o vai aparecer
        setOpaque(false);
    }
 
    public void setImage(String url) {
        image = new ImageIcon(getClass().getResource(url)).getImage();
    }
 
    @Override
    public void paintComponent(Graphics g) {
        /*
         * A imagem vai ser desenhada em x=0, y=0 e usando o tamanho real da imagem
         * � fundamental que seja chamado o m�todo drawImage antes de se chamar o
         * m�todo paintComponent da superclasse.
         */
        g.drawImage(image, 0, 0, this);
 
        /*
         * Ao desenharmos primeiro a imagem garantimos que qualquer componente
         * que seja adicionado ao painel fique por cima da imagem, criando assim
         * o efeito de imagem de background que pretendemos.
         *
         * Se trocarmos a ordem, os efeitos podem n�o ser os esperados j� que a
         * imagem vai ser desenhada em cima dos componentes que est�o neste JPanel.
         * Se n�o existirem componente ent�o a ordem n�o � relevante.
         */
        super.paintComponent(g);
    }
}
