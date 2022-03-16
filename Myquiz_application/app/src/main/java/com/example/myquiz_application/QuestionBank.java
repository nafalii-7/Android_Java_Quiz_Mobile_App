package com.example.myquiz_application;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private static List<QuestionsList> quizQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        //QuestionsList objets qui contiennent les questions avec leurs options et la reponse
        final QuestionsList question1 = new QuestionsList("Quel est le plus long fleuve du monde?", "Abou Regreg", "Nil", "Mississippi", "Amazone", "Nil", "");
        final QuestionsList question2 = new QuestionsList("Quel est le continent sur lequel se trouve l’état de Palestine?", "Afrique", "Asie", "Europe", "Océanie", "Asie", "");
        final QuestionsList question3 = new QuestionsList("Quelle est le plus grand pays dans l'Afrique en supérficie ?", "Congo", "Soudan", "Algérie", "Libye", "Algérie", "");
        final QuestionsList question4 = new QuestionsList("Combien de pays arabes y a-t-il sur le continent africain?", "6 pays", "9 pays", "10 pays", "5 pays", "9 pays", "");
        final QuestionsList question5 = new QuestionsList("Combien de dents un humain adulte a-t-il?", "32", "28", "26", "40", "32", "");
        final QuestionsList question6 = new QuestionsList("Combien de vertèbres dans la colonne vertébrale?", "33", "24", "30", "50", "33", "");
        final QuestionsList question7 = new QuestionsList("Quelle est la planète la plus chaude?", "Mercure", "Vénus", "Saturne", "Mars", "Vénus", "");
        final QuestionsList question8 = new QuestionsList("Quelle est la durée de l’année galactique(L'année cosmique)", "De 100 à 150 millions d'années", "De 225 à 250 millions d'années", "De 350 à 375 millions d'années", "De 200 à 220 millions d'années", "De 225 à 250 millions d'années", "");
        final QuestionsList question9 = new QuestionsList("Quel est le continent le plus peuplé de la planète?", "Afrique", "Europe", "Amérique", "Asie", "Asie", "");
        final QuestionsList question10 = new QuestionsList("Quel est le plus long fleuve du monde?", "Abou Regreg", "Nil", "Mississippi", "Amazone", "Nil", "");
        final QuestionsList question11 = new QuestionsList("Quel est le plus haut sommet du monde ", "Aconcagua", "Mont Blanc", "Denali", "Everest", "Everest", "");
        final QuestionsList question12= new QuestionsList("Quelle est la capitale du Portugal?", "Lisbonne", "Porto", "Prague", "Portugal", "Lisbonne", "");
        final QuestionsList question13 = new QuestionsList("Combien de fois le Brézil a gagné la Coupe du Monde", "2", "4", "1", "5", "5", "");
        final QuestionsList question14 = new QuestionsList("Quelle est la langue officielle du Brézil ?", "Anglais", "Portugais", "Espagnol", "Français", "Portugais", "");
        final QuestionsList question15 = new QuestionsList("Quel est la capitale du Canada ?", "Ottawa", "Québec", "Toronto", "Montréal", "Ottawa", "");
        final QuestionsList question16 = new QuestionsList("Combien d'États y-a-t-il aux États-Unis ?", "40", "50", "60", "70", "50", "");
        final QuestionsList question17 = new QuestionsList("Quel est le plus grand océan du monde ?", "Pacifique", "Atlantique", "Arctique", "Indien", "Pacifique", "");
        final QuestionsList question18 = new QuestionsList("Quand la Seconde Guerre mondiale a-t-elle pris fin ?", "1942", "1950", "1945", "1941", "1945", "");
        final QuestionsList question19 = new QuestionsList("Qui a écrit Le songe d'une nuit d'été ?", "Michel de Montaigne", "Voltaire", "Molière", "William Shakespeare", "William Shakespeare", "");
        final QuestionsList question20 = new QuestionsList("Quelle est la capitale de Congo ?", "Brazzaville", "Congo", "Kinshasa", "Lubumbashi", "Brazzaville", "");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);
        questionsLists.add(question11);
        questionsLists.add(question12);
        questionsLists.add(question13);
        questionsLists.add(question14);
        questionsLists.add(question15);
        questionsLists.add(question16);
        questionsLists.add(question17);
        questionsLists.add(question18);
        questionsLists.add(question19);
        questionsLists.add(question20);


        return questionsLists;
    }

    public static List<QuestionsList> getQuestions(){
        return quizQuestions();
    }

}
