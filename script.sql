--
-- Base de Dados: `db_sistema`
--
CREATE DATABASE IF NOT EXISTS `db_sistema` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_sistema`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL,
  `fiador` varchar(60) NOT NULL,
  `contatofiador` varchar(14) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `valorTotal` double NOT NULL,
  `dataCompra` date NOT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  `idFornecedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idFornecedor` (`idFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `idFornecedor` int(11) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(20) NOT NULL,
  `ins_estadual` varchar(11) NOT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFornecedor`),
  KEY `idPessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nrocarteira` varchar(20) NOT NULL,
  `salario` double NOT NULL,
  `funcao` varchar(20) NOT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFuncionario`),
  KEY `idPessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemcompra`
--

CREATE TABLE IF NOT EXISTS `itemcompra` (
  `idItemCompra` int(11) NOT NULL AUTO_INCREMENT,
  `idCompra` int(11) DEFAULT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `quantidade` double NOT NULL,
  PRIMARY KEY (`idItemCompra`),
  KEY `idProduto` (`idProduto`),
  KEY `idCompra` (`idCompra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemvenda`
--

CREATE TABLE IF NOT EXISTS `itemvenda` (
  `idItemVenda` int(11) NOT NULL AUTO_INCREMENT,
  `idVenda` int(11) DEFAULT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `quantidade` double NOT NULL,
  PRIMARY KEY (`idItemVenda`),
  KEY `idVenda` (`idVenda`),
  KEY `idProduto` (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `loja`
--

CREATE TABLE IF NOT EXISTS `loja` (
  `idLoja` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `telefone` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  PRIMARY KEY (`idLoja`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `idPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `cpf_cnpj` varchar(14) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoaloja`
--

CREATE TABLE IF NOT EXISTS `pessoaloja` (
  `idPessoaLoja` int(11) NOT NULL AUTO_INCREMENT,
  `idPessoa` int(11) DEFAULT NULL,
  `idLoja` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPessoaLoja`),
  KEY `idPessoa` (`idPessoa`),
  KEY `idLoja` (`idLoja`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) NOT NULL,
  `marca` varchar(60) NOT NULL,
  `valor` varchar(60) NOT NULL,
  `unidadeMedida` varchar(60) NOT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(60) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idPessoa` (`idPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE IF NOT EXISTS `venda` (
  `idVenda` int(11) NOT NULL AUTO_INCREMENT,
  `valorTotal` double NOT NULL,
  `dataVenda` date NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `idFuncionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `venda_ibfk_1` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`idFornecedor`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fornecedor_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`);

--
-- Limitadores para a tabela `itemcompra`
--
ALTER TABLE `itemcompra`
  ADD CONSTRAINT `itemcompra_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`),
  ADD CONSTRAINT `itemcompra_ibfk_2` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`);

--
-- Limitadores para a tabela `itemvenda`
--
ALTER TABLE `itemvenda`
  ADD CONSTRAINT `itemvenda_ibfk_1` FOREIGN KEY (`idVenda`) REFERENCES `venda` (`idVenda`),
  ADD CONSTRAINT `itemvenda_ibfk_2` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`);

--
-- Limitadores para a tabela `pessoaloja`
--
ALTER TABLE `pessoaloja`
  ADD CONSTRAINT `pessoaloja_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`),
  ADD CONSTRAINT `pessoaloja_ibfk_2` FOREIGN KEY (`idLoja`) REFERENCES `loja` (`idLoja`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`idPessoa`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `venda_ibfk_2` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idFuncionario`);
