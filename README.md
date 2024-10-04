# Descrição do projeto

- O argoCD é utilizado para monitorar branchs do repositório git, no momento que ocorrer commits será aplicado as mudanças nos arquivos yaml do kubernetes.
- Mais utilizado para automação de atualização de versão do sistema.
- Neste projeto temos configurado padrões nos commits com feat, fix, etc. Juntamente com as actions do gitHub que acionam e verificam esses padões, sendo assim realizam automaticamente a atualização de versão do sistema.
- Com isso a unica preocupação é com os commits que devem ser padronizados para tal funcionamento.

## Ferramentas utilizadas

- ArgoCD https://argoproj.github.io/cd/
- Kubernetes
- Docker
- DockerHub
- Spring Boot 3
- Java 17
- Nextjs 14+
- gitHub actions

## Passos para funcionamento

#### Dependencias para serem instaladas na maquina local ou servidor:

- https://github.com/willianBinda/conf-kubernetes.git
  - kind (cluster) https://kind.sigs.k8s.io/docs/user/quick-start/#installation
  - kubectl https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/
  - k8s.lens https://k8slens.dev/
  - kubeseal https://archive.eksworkshop.com/beginner/200_secrets/installing-sealed-secrets/

#### Inicialização do kubernetes

- -> kind-cluster ->

```bash
./1-create-cluster.sh
```

- -> kind-cluster ->

```bash
./2-create-argoCD.sh
```

- -> kind-cluster ->

```bash
./3-create-scale-secret.sh
```

#### Inicializando projeto

- -> enviroments -> stage ->

```bash
kubectl apply -f 0-application.yaml
```

#### Visualizar argoCD

- Abrir a interface `Lens` do `k8s.lens`
- Navegar para `service`
- Acessar `argocd-service`
- Abilitar a porta do argoCD na `Forward Port`
- Acessar na web o argoCD
- usuario: admin
- senha: Navegar para secrest e visualizar a propriedade admin-argocd-inicializate
