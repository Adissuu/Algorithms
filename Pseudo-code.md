# Programming Questions - Pseudo Code

    rearrangeReservations(rDate[], rSlot[], rMedicare[])

     for (int i = 0; i < (date_arr.length) - 1; ++i) {

            for (int j = 0; j < (date_arr.length) - i - 1; ++j) {

                if (date_arr[j + 1].compareTo(date_arr[j]) < 1) {

                    LocalDate swap = date_arr[j];
                    date_arr[j] = date_arr[j + 1];
                    date_arr[j + 1] = swap;

                    int swup = slot_arr[j];
                    slot_arr[j] = slot_arr[j + 1];
                    slot_arr[j + 1] = swup;

                    String swop = medi_arr[j];
                    medi_arr[j] = medi_arr[j + 1];
                    medi_arr[j + 1] = swop;
                }
            }