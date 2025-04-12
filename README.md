Sistema de Transferências - Desafio Técnico PicPay
API REST para transferências entre usuários com regras específicas

✅ Funcionalidades-Chave
Dois tipos de usuários: Comum (pode enviar/receber) e Lojista (só recebe)
Validações: saldo suficiente, CPF/email únicos, restrições por tipo
Transações atômicas com rollback automático

Integração com serviços externos:
Autorização de transações (mock)
Notificações assíncronas (mock)

🛠 Tech Stack
Java 21 | Spring Boot | JPA/Hibernate | PostgreSQL | Docker | JUnit/Mockito

⚡ Endpoint Principal
POST /transferencias
{
  "valor": 150.50,
  "remetente": 123,  # ID do usuário comum
  "destinatario": 456 # ID do usuário/lojista
}

🏗 Arquitetura
Camadas claras (Controller - Infrastructure - Services)
Padrão Strategy para tipos de usuário
Tratamento de erros customizado
Cache para consultas frequentes

🚀 Execução
docker-compose up -d  # Sobe PostgreSQL
mvn spring-boot:run   # Inicia aplicação

✅ Atendimento a Requisitos
Restrição de transferências por lojistas
Validação em dois níveis (saldo + serviço externo)
Notificações resilientes a falhas
Transações ACID-compliant

Projeto desenvolvido para demonstração de habilidades em backend com clean architecture e boas práticas.
