public class findGenes {
  public static void main(String[] args) {
    String dna = "AATGCGTTAATATGGT";

    String thatGene = findGene(dna, 0);
    System.out.println(thatGene);
    System.out.println(countGene(dna));
  }

  public static int countGene(String dna) {
    int startInd = 0;
    int count = 0;
    while(true) {
      String currGene = findGene(dna, startInd);
      if(currGene.isEmpty()) {
        break;
      }
      count++;
      startInd = currGene.length() + dna.indexOf(currGene, startInd);
    }
    return count;
  }

  public static String findGene(String dna, int where) {
    int startInd = dna.indexOf("ATG", where);
    if (startInd == -1) {
      return "";
    }
    int taa = findStopCodon(dna, startInd, "TAA");
    int tag = findStopCodon(dna, startInd, "TAG");
    int tga = findStopCodon(dna, startInd, "TGA");

    int minIndex = Math.min(taa, Math.min(tag, tga));
    if(minIndex == dna.length()) {
      return "";
    }

    return dna.substring(startInd, minIndex + 3);
  }

  public static int findStopCodon(String dna, int startInd, String stopCodon) {
    int currInd = dna.indexOf(stopCodon, startInd + 3);

    while(currInd != -1) {
      if((currInd - startInd) %3 == 0) {
        return currInd;
      } else {
        currInd = dna.indexOf(stopCodon, currInd + 1);
      }
    }
    return dna.length();
  }

}
