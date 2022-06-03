import NumberFormat from 'react-number-format';

const FormatValor = () => {
  return (
    <NumberFormat 
    prefix="R$"
    allowNegative={false}
    displayType="input"

    />
  )
}

export default FormatValor