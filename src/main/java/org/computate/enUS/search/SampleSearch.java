package org.computate.enUS.search;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SampleSearch {

	@Test public void testNames() throws Exception {
		HttpSolrClient solrClient = new HttpSolrClient.Builder("http://localhost:10383/solr/sample-search").build();
		ClassLoader classLoader = getClass().getClassLoader();
		File firstNameFile = new File(classLoader.getResource("census-derived-all-first.txt").getFile());
		List<String> nameLines = FileUtils.readLines(firstNameFile);

		for(String nameLine : nameLines) {
			String[] nameLineParts = StringUtils.split(nameLine);
			if(nameLineParts.length == 4) {
				String pk = "first-name-" + nameLineParts[0];
				String firstName = nameLineParts[0];
				Double nameScore = Double.parseDouble(nameLineParts[1]);
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("firstName_indexed_string", firstName);
				document.setField("firstName_stored_string", firstName);
				document.setField("firstName_phonetic_en", firstName);
				document.setField("firstName_text_enUS", firstName);
				document.setField("firstName_suggest", firstName);
				document.setField("nameScore_indexed_double", nameScore);
				document.setField("nameScore_stored_double", nameScore);
				document.setField("firstName_indexed_boolean", true);
				document.setField("firstName_stored_boolean", true);
				document.setField("password_random", firstName);
				solrClient.add(document);
				solrClient.commit();
			}
		}
	}

	@Test public void testPhrases() throws Exception {
		HttpSolrClient solrClient = new HttpSolrClient.Builder("http://localhost:10383/solr/sample-search").build();
		String enUSPhrase1 = "One for the money, ";
		String enUSPhrase2 = "two for the show, ";
		String enUSPhrase3 = "three to get ready, ";
		String enUSPhrase4 = "and four to go.";
		String esESPhrase1 = "Uno para el dinero, ";
		String esESPhrase2 = "dos para el espectáculo, ";
		String esESPhrase3 = "tres para prepararse ";
		String esESPhrase4 = "y cuatro para ir.";
		String frFRPhrase1 = "Un pour l'argent, ";
		String frFRPhrase2 = "deux pour le spectacle, ";
		String frFRPhrase3 = "trois pour se préparer ";
		String frFRPhrase4 = "et quatre pour y aller.";
		{
			SolrInputDocument document = new SolrInputDocument();
			String pk = "phrase-1";
			document.setField("pk", pk);
			document.setField("phrase_indexed_string", enUSPhrase1);
			document.setField("phrase_stored_string", enUSPhrase1);
			document.setField("phrase_phonetic_en", enUSPhrase1);
			document.setField("phrase_text_enUS", enUSPhrase1);
			document.setField("phrase_text_esES", esESPhrase1);
			document.setField("phrase_text_frFR", frFRPhrase1);
			document.setField("phrase_all_text_enUS", enUSPhrase1 + esESPhrase1 + frFRPhrase1);
			document.setField("phrase_all_text_esES", enUSPhrase1 + esESPhrase1 + frFRPhrase1);
			document.setField("phrase_all_text_frFR", enUSPhrase1 + esESPhrase1 + frFRPhrase1);
			document.setField("phrase_suggest", enUSPhrase1);
			document.setField("phrase_indexed_boolean", true);
			document.setField("phrase_stored_boolean", true);
			solrClient.add(document);
			solrClient.commit();
		}
		{
			SolrInputDocument document = new SolrInputDocument();
			String pk = "phrase-2";
			document.setField("pk", pk);
			document.setField("phrase_indexed_string", enUSPhrase2);
			document.setField("phrase_stored_string", enUSPhrase2);
			document.setField("phrase_phonetic_en", enUSPhrase2);
			document.setField("phrase_text_enUS", enUSPhrase2);
			document.setField("phrase_text_esES", esESPhrase2);
			document.setField("phrase_text_frFR", frFRPhrase2);
			document.setField("phrase_all_text_enUS", enUSPhrase2 + esESPhrase2 + frFRPhrase2);
			document.setField("phrase_all_text_esES", enUSPhrase2 + esESPhrase2 + frFRPhrase2);
			document.setField("phrase_all_text_frFR", enUSPhrase2 + esESPhrase2 + frFRPhrase2);
			document.setField("phrase_suggest", enUSPhrase2);
			document.setField("phrase_indexed_boolean", true);
			document.setField("phrase_stored_boolean", true);
			solrClient.add(document);
			solrClient.commit();
		}
		{
			SolrInputDocument document = new SolrInputDocument();
			String pk = "phrase-3";
			document.setField("pk", pk);
			document.setField("phrase_indexed_string", enUSPhrase3);
			document.setField("phrase_stored_string", enUSPhrase3);
			document.setField("phrase_phonetic_en", enUSPhrase3);
			document.setField("phrase_text_enUS", enUSPhrase3);
			document.setField("phrase_text_esES", esESPhrase3);
			document.setField("phrase_text_frFR", frFRPhrase3);
			document.setField("phrase_all_text_enUS", enUSPhrase3 + esESPhrase3 + frFRPhrase3);
			document.setField("phrase_all_text_esES", enUSPhrase3 + esESPhrase3 + frFRPhrase3);
			document.setField("phrase_all_text_frFR", enUSPhrase3 + esESPhrase3 + frFRPhrase3);
			document.setField("phrase_suggest", enUSPhrase3);
			document.setField("phrase_indexed_boolean", true);
			document.setField("phrase_stored_boolean", true);
			solrClient.add(document);
			solrClient.commit();
		}
		{
			SolrInputDocument document = new SolrInputDocument();
			String pk = "phrase-4";
			document.setField("pk", pk);
			document.setField("phrase_indexed_string", enUSPhrase4);
			document.setField("phrase_stored_string", enUSPhrase4);
			document.setField("phrase_phonetic_en", enUSPhrase4);
			document.setField("phrase_text_enUS", enUSPhrase4);
			document.setField("phrase_text_esES", esESPhrase4);
			document.setField("phrase_text_frFR", frFRPhrase4);
			document.setField("phrase_all_text_enUS", enUSPhrase4 + esESPhrase4 + frFRPhrase4);
			document.setField("phrase_all_text_esES", enUSPhrase4 + esESPhrase4 + frFRPhrase4);
			document.setField("phrase_all_text_frFR", enUSPhrase4 + esESPhrase4 + frFRPhrase4);
			document.setField("phrase_suggest", enUSPhrase4);
			document.setField("phrase_indexed_boolean", true);
			document.setField("phrase_stored_boolean", true);
			solrClient.add(document);
			solrClient.commit();
		}
	}

	@Test public void testPasswords() throws Exception {
		HttpSolrClient solrClient = new HttpSolrClient.Builder("http://localhost:10383/solr/sample-search").build();
		ClassLoader classLoader = getClass().getClassLoader();
		{
			File firstNameFile = new File(classLoader.getResource("passwords.txt").getFile());
			List<String> passwordLines = FileUtils.readLines(firstNameFile);
	
			for(String passwordLine : passwordLines) {
				String password = StringUtils.trim(passwordLine);
				String pk = "password-" + password;
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
		}
	}

	@Test public void testPasswordsWithRoles() throws Exception {
		HttpSolrClient solrClient = new HttpSolrClient.Builder("http://localhost:10383/solr/sample-search").build();
		ClassLoader classLoader = getClass().getClassLoader();
		{
			File firstNameFile = new File(classLoader.getResource("passwords.txt").getFile());

			{
				String password = "asdfghjkl";
				String pk = "password-" + password;
				String name = "Danny Freese";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name);
				document.setField("role_indexed_strings", name);
				document.setField("role_stored_strings", name);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
			{
				String password = "qwertyuiop";
				String pk = "password-" + password;
				String name = "Carl Mes";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name);
				document.setField("role_indexed_strings", name);
				document.setField("role_stored_strings", name);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
			{
				String password = "zyxwvutsrq";
				String pk = "password-" + password;
				String name = "Grant Costa";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name);
				document.setField("role_indexed_strings", name);
				document.setField("role_stored_strings", name);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
			{
				String password = "abcdefghijklmnop";
				String pk = "password-" + password;
				String name = "Sal Elrahal";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name);
				document.setField("role_indexed_strings", name);
				document.setField("role_stored_strings", name);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
			{
				String password = "0123456789";
				String pk = "password-" + password;
				String name = "Brad Davis";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name);
				document.setField("role_indexed_strings", name);
				document.setField("role_stored_strings", name);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
			{
				String password = "3.1415926535";
				String pk = "password-" + password;
				String name = "Adam Seeley";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name);
				document.setField("role_indexed_strings", name);
				document.setField("role_stored_strings", name);
				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
			{
				String password = "010101010101";
				String pk = "password-" + password;
				String name1 = "Christopher Tate";
				String name2 = "Steve Erwin";
				String name3 = "Maximus Decimus Meridius";
				String name4 = "Christopher Tate";
				SolrInputDocument document = new SolrInputDocument();
				document.setField("pk", pk);
				document.setField("password_indexed_string", password);
				document.setField("password_stored_string", password);
				document.setField("password_phonetic_en", password);
				document.setField("password_text_enUS", password);
				document.setField("password_suggest", password + " " + name1 + " " + name2 + " " + name3 + " " + name4);

				document.addField("role_indexed_strings", name1);
				document.addField("role_stored_strings", name1);

				document.addField("role_indexed_strings", name2);
				document.addField("role_stored_strings", name2);

				document.addField("role_indexed_strings", name3);
				document.addField("role_stored_strings", name3);

				document.addField("role_indexed_strings", name4);
				document.addField("role_stored_strings", name4);

				document.setField("password_random", password);
				document.setField("password_indexed_boolean", true);
				document.setField("password_stored_boolean", true);
				solrClient.add(document);
				solrClient.commit();
			}
		}
	}
}
