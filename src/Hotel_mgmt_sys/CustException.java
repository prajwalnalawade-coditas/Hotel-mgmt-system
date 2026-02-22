package Hotel_mgmt_sys;
    class NoRoomException extends Exception {
        public NoRoomException(String msg) {
            super(msg);
        }
    } class BookingException extends Exception {
        public BookingException(String msg) {
            super(msg);
        }
    } class UserNotFoundException extends Exception {
        public UserNotFoundException(String msg) {
            super(msg);
        }
    } class InvalidUserException extends Exception {
        public InvalidUserException(String msg) {
            super(msg);
        }
    }

