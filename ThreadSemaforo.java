/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;


    import java.awt.Rectangle ;
    import java.util.Random ;
    import java.util.concurrent.Semaphore ;

    import javax.swing.JButton ;
    import javax.swing.JLabel ;


    public class ThreadSemaforo extends Thread {

        private JLabel carro, semaforoVermelho, semaforoVerde;
        private JLabel fundoInicio;
        private JButton btnInicio;
        private int op;
        private static int aux;

        private Semaphore semaforo;

        /**
         * Construtor
         *
         * @param carro recebe o JLabel correspondente ao carro em questão
         * @param semaforoVermelho recebe o JLabel correspondente ao semáforo
         * vermelho em questão
         * @param semaforoVerde recebe o JLabel correspondente ao semáforo verde
         * em questão
         * @param semaforo recebe a variável semaforo do tipo Semaphore
         * @param fundoInicio recebe o JLabel do fundo de início
         * @param btnInicio recebe o JButton que quando clicado inicia a
         * aplicação
         * @param op recebe um valor inteiro que ajudará no desenvolvimento da
         * lógica
         */
        public ThreadSemaforo(JLabel carro, JLabel semaforoVermelho, JLabel semaforoVerde,
                Semaphore semaforo, JLabel fundoInicio, JButton btnInicio, int op) {

            this.carro = carro;
            this.semaforoVermelho = semaforoVermelho;
            this.semaforoVerde = semaforoVerde;
            this.semaforo = semaforo;
            this.fundoInicio = fundoInicio;
            this.btnInicio = btnInicio;
            this.op = op;

        }

        /**
         * Método run da classe ThreadSemaforo que chama o método executa sem
         * passagem de parâmetros. Quando todas Threads terminarem, o fundo e o botão inicio voltam e aux=0;
         */
        public void run() {
            executa();
            if (aux == 4) {
                fundoInicio.setVisible(true);
                btnInicio.setVisible(true);
                aux = 0;
            }
        }

        /**
         * Método executa() que possui dentro de um try catch a utilização de
         * semaforos a fim de definir um sincronismo nas Threads
         */
        public void executa() {
            try {

                semaforo.acquire();//pega o semáforo da vez
                acionaCarro();

            } catch (Exception e) {

                e.printStackTrace();//informações detalhadas sobre exceções.

            } finally {

                semaforo.release();//libera semáforo após o uso
            }
            aux++;
        }

        /**
         * Método acionaCarro() que é responsável por definir a movimentação do
         * carro em questão
         */
        public void acionaCarro() {
            Rectangle posicao;
            posicao = carro.getBounds();//chama o método que retorna um objeto rectangle. 'posicao' contém as coordenadas e dimensões atuais do componente carro em relação ao seu contêiner pai.
            int aux = 0;
            Random random = new Random(); //números aleatórios

            switch (op) {
                case 1:
                    semaforoVermelho.setVisible(false);
                    semaforoVerde.setVisible(true);
                    while (aux < 2) {
                        try {
                            Thread.sleep(10);//tempo de pausa da thread
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        if (aux == 1) {
                            posicao.y = (posicao.y) + (random.nextInt(2));
                            if (posicao.y >= 46) {
                                aux = 2;
                            }
                        }
                        posicao.y = (posicao.y) + (random.nextInt(5));
                        carro.setBounds(posicao);//método que pertence à classe Component. O carro é setado para essa posição atual
                        if (posicao.y >= 800) {
                            posicao.y = -100;
                            aux = 1;
                        }

                    }

                    semaforoVermelho.setVisible(true);
                    semaforoVerde.setVisible(false);

                    break;
                case 2:
                    semaforoVermelho.setVisible(false);
                    semaforoVerde.setVisible(true);

                    while (aux < 2) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        if (aux == 1) {
                            posicao.x = (posicao.x) - (random.nextInt(2));
                            if (posicao.x <= 560) {
                                aux = 2;
                            }
                        }
                        posicao.x = (posicao.x) - (random.nextInt(5));
                        carro.setBounds(posicao);
                        if (posicao.x <= -100) {
                            posicao.x = 800;
                            aux = 1;
                        }

                    }

                    semaforoVermelho.setVisible(true);
                    semaforoVerde.setVisible(false);

                    break;
                case 3:
                    semaforoVermelho.setVisible(false);
                    semaforoVerde.setVisible(true);

                    while (aux < 2) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        if (aux == 1) {
                            posicao.y = (posicao.y) - (random.nextInt(2));
                            if (posicao.y <= 549) {
                                aux = 2;
                            }
                        }
                        posicao.y = (posicao.y) - (random.nextInt(5));
                        carro.setBounds(posicao);
                        if (posicao.y <= -100) {
                            posicao.y = 800;
                            aux = 1;
                        }

                    }

                    semaforoVermelho.setVisible(true);
                    semaforoVerde.setVisible(false);

                    break;
                case 4:
                    semaforoVermelho.setVisible(false);
                    semaforoVerde.setVisible(true);

                    while (aux < 2) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        if (aux == 1) {
                            posicao.x = (posicao.x) + (random.nextInt(2));
                            if (posicao.x >= 48) {
                                aux = 2;
                            }
                        }
                        posicao.x = (posicao.x) + (random.nextInt(5));
                        carro.setBounds(posicao);
                        if (posicao.x >= 800) {
                            posicao.x = -100;
                            aux = 1;
                        }

                    }

                    semaforoVermelho.setVisible(true);
                    semaforoVerde.setVisible(false);

                    break;
            }
        }
    }

