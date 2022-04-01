terraform {  
  required_providers {  ///Profedores Necessarios
    aws = {       //Provedor

      source  = "hashicorp/aws"   
      version = "~> 3.27" //Versão
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {    ///Configurações do Provedor 1
  profile = "default"  // Perfil
  region  = "us-east-1" //Região do Provedor
  access_key = "AKIA3AVBZWEHRSRUSBQZ" ///id chave
  secret_key = "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" //chave
}

resource "aws_instance" "app_server3" {  ///Titpo da instancia
  count         = 1   /// Numero de maquinas que vai subir
  ami           = "ami-04505e74c0741db8d"  //Imagem da Maquina - Tipo de maquina 
  instance_type = "t2.micro" //Tipo de Instacia
  key_name = "ChaveAcessoEC2" //Par de chaves de conexão
  #user_data = <<-EOF
                #!/bin/bash
                #cd /home/ubuntu
                #echo “<h1>Redes de Computadores Acesso</h1>” > index.html
                #nohup busybox httpd -f -p 8080 &   ////Comando para acessar o servidor web
                #EOF
  tags = {
    Name = "atividade 1" //Nome da instacia
  }
  vpc_security_group_ids = ["${aws_security_group.acesso-ssh.id}"] ///Fazer o link com grupo de segurança e a instancia
}

 

