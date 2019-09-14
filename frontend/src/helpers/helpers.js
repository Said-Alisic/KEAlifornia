
export const ThreeDaysLater = () => {
  const date = new Date();
  const threeDaysLater = date.setDate(date.getDate() + 3);
  return new Date(threeDaysLater);
}

// Convert to neccessary date format with padded zero at the beginning if date/month is a singular number
export const formatDate = (date) => {
  const day = ('0' + date.getDate()).slice(-2);
  const month = ('0' + (date.getMonth() + 1)).slice(-2);
  const year = date.getFullYear();

  return `${day}-${month}-${year}`;
}