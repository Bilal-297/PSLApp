package com.example.parser;

import java.io.StringReader;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.trees.Tree;
public class Translate{

    final String model = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
    final TokenizerFactory<CoreLabel> tokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(), "invertible=true");
    final LexicalizedParser parser = LexicalizedParser.loadModel(model, "-maxLength", "80", "-retainTmpSubcategories");

    public Tree parse(String str) {
        List<CoreLabel> tokens = tokenize(str);
        Tree tree = parser.apply(tokens);
        return tree;
    }

    public List<CoreLabel> tokenize(String str) {
        Tokenizer<CoreLabel> tokenizer = tokenizerFactory.getTokenizer(new StringReader(str));
        return tokenizer.tokenize();
    }


}



